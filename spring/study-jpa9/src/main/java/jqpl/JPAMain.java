package jqpl;

import jqpl.entity.Member;
import jqpl.entity.Team;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studyJPA9");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team team = new Team();
            team.setName("team1");
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.changeTeam(team);
            Member member1 = new Member();
            member1.setUsername("member2");
            member1.setAge(14);
            member1.changeTeam(team);
            Member member2 = new Member();
            member2.setUsername("team1");
            member2.setAge(12);
            member2.changeTeam(team);
            em.persist(team);
            em.persist(member);
            em.persist(member1);
            em.persist(member2);
            em.flush();
            em.clear();
//            **** jpql 기본 프로젝션 ****
//            TypedQuery<Member> query1 = em.createQuery("select m from Member as m", Member.class);
//            List<Member> resultList = query1.getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member.username = " + member1.getUsername());
//                System.out.println("member.age = " + member1.getAge());
//            }
//            TypedQuery<Member> query2 = em.createQuery("select m from Member as m where m.id = 1", Member.class);
//            Member result = query2.getSingleResult();
//            System.out.println("result = " + result);
//
//            Member singleResult = em.createQuery("select m from Member as m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("singleResult = " + singleResult);
//            **** 페이징 ****
//            List<Member> result = em.createQuery("select m from Member as m order by m.age desc", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//            System.out.println("result.size = " + result.size());
//            for (Member members : result) {
//                System.out.println("members = " + members);
//            }
//            Team findTeam = em.find(Team.class, 1L);
//            System.out.println("findTeam = " + findTeam);
//            String query = "select m from Member as m left join m.team t"; // 내부, 외부 조인 join -> [inner] join, left(right) join -> left [outer] join
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//            for (Member members : result) {
//                System.out.println("members = " + members);
//            }
//            String query = "select m from Member as m, Team as t where m.username = t.name"; // 세타 조인 (cross join)
//            List<Member> result = em.createQuery(query, Member.class).getResultList();
//            for (Member members : result) {
//                System.out.println("members = " + members);
//            }
//            ON_절을 이용해 join 문에 조건을 걸 수도 있음

//            CASE
//            String query = "select " +
//                                "case when m.age <= 10 then '학생요금' " +
//                                "     when m.age >= 60 then '경로요금' " +
//                                "     else '일반요금' " +
//                                "end " +
//                            "from Member m";
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//            for (String s : result) {
//                System.out.println("요금 = " + s);
//            }
            String query = "select coalesce(m.username, '이름 없는 회원') as username from Member m";
            List<String> result = em.createQuery(query, String.class)
                    .getResultList();
            for (String s : result) {
                System.out.println("이름 없는 회원 조회 = " + s);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
    public <T> T getInstance(Class<T> classType) throws Exception {
        T instance = createInstance(classType);
        Arrays.stream(classType.getFields())
                .forEach(e -> {
                    if (e.isAnnotationPresent(Inject.class)) {
                        Object fieldInstance = createInstance(e.getType());
                        e.setAccessible();
                        try {
                            e.set(instance, fieldInstance);
                        } catch (IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        T returnInstance = null;
        try {
            returnInstance = classType.getConstructor(null).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return returnInstance;
    }
}

/*
프로젝션

. SELECT 절에 조회할 대상을 지정하는 것
. 프로젝션 대상 : 엔티티, 임베디드 타입, 스칼라 타입(숫자 문자 등 기본 데이터 타입)
. SELECT m FROM Member m, Member.class -> 엔티티 프로젝션
. SELECT m.team FROM Member m, Team.class -> 엔티티 프로젝션
  => SELECT t FROM Member m JOIN m.team t, Team.class 처럼 실제 SQL 문 처럼 조인을 해주는 것이 좋다.
. SELECT o.address FROM Order o, Address.class -> 임베디드 타입 프로젝션
  => 임베디드 타입만으로는 조회 불가능, 소속된 엔티티가 명시되어야 함
. SELECT m.username, m.age FROM Member m -> 스칼라 타입 프로젝션
  => 여러가지 타입이 섞여서 반환되기 때문에 Query 타입으로 반환됨 (Object[] 로 타입 캐스팅을 하거나, List<Object[]> 로 명시)
  => DTO 객체로 new 하여 반환할 수도 있다.
    // "SELECT new jpql.entity.dto.MemberDTO(m.username, m.age) from Member as m, MemberDTO.class
    // 위 처럼 생성자를 사용하는 것 처럼 호출 가능 (패키지 이름까지 전부 작성하여야 함, 순서와 타입이 일치하는 생성자 필요)
. DISTINCT 로 중복 제거


서브 쿼리

. 나이가 평균보다 많은 회원
  select m from Member as m where m.age > (select avg(m2.age) from Member as m2)
. 한 건이라도 주문한 고객
  select m from Member as m where (select count(o) from Order as o where o.member = m) > 0
* tip : 서브 쿼리를 작성할 때, 서브 쿼리에는 본 쿼리와 연관된 요소를 사용하지 않는 것이 좋다. (사용 시 성능 저하)
        => ex) 첫 쿼리의 m 과 m2 는 사실상 서로 같지만, 각각 따로 사용 / 반면 두번째 쿼리에서는 m 을 두 번 사용 (성능면에서 좋지 않음)


서브 쿼리 지원 함수

. [NOT] exists (SubQuery) : 서브 쿼리에 결과가 존재하면 참
  => {ALL | ANY | SOME} (SubQuery) : 조건을 모두 | 하나라도 만족하면 참 (ANY = SOME)
    // ex) select m from Member as m where exists (select t from m.team t where t.name = '팀A')
    // ex) select o from Order as o where o.orderAmount > all (select p.stockAmount from Product as p)
    // ex) select m from Member as m there m.team = any (select t from Team as t)
. [NOT] in (SubQuery) : 서브 쿼리의 결과 중 하나라도 같은 것이 있으면 참


JPA 서브 쿼리의 한계 (JPA 표준)

. JPA 는 WHERE, HAVING 절에서만 서브 쿼리 사용 가능
. SELECT 절도 가능 (하이버네이트에서 지원)
. FROM 절의 서브 쿼리는 현재 JPQL 에서 불가능 // 하이버네이트 6 이후 버전부터는 FROM 절 서브 쿼리를 지원함


조건 Case 식

. COALESCE : 하나씩 조회해서 null 이 아니면 반환
. NULLIF : 두 값이 같으면 null 반환, 다르면 첫번째 값 반환

 */