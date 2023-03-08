package exam01;

import java.util.ArrayList;

public class Manager {

	private ArrayList <Movie> movies = new ArrayList<>();

	public void addMovie(Movie movie) {
		movies.add(movie);
	} // 신규 영화 등록 기능

	public ArrayList <Movie> getMovies() {
		return movies;
	} // 영화 목록 반환 기능 

	public ArrayList<Movie> getMovies(String search) {
		// 영화 검색 기능 

		ArrayList <Movie> result = new ArrayList<>();

		for(Movie movie : movies) {
			if(movie.getMovieName().equals(search)) {//검색 하려는 제목이 영화제목에 포함 된 것들은

				result.add(movie);//result ArrayList에 옮겨 저장 	
			}	     
		}
		return result;	
	}
	public int getIndexByTitle(String search) { 
		//배열의 인덱스번호 리턴하는 메서드
		for(int i = 0; i<movies.size(); i++) {
			
			if(movies.get(i).getMovieName().equals(search)) {
				
				return i; //영화를 찾으면 해당 영화의 index 반환 
			}	     
		}
		return -1; //영화를 찾지 못할 시 -1 반환
	}
	public void updateByIndex (int index, Movie dst) { 
		//수정기능                          //무비형 인스턴스로 넘겨받음 !
		
		movies.set(index, dst);
		
		//index : 배열의 번호
		//dst : 바꿀 내용 !!

	}
	public int deleteByTitle(String title) { 
		//삭제기능
		
		int index = this.getIndexByTitle(title);
		//this. 가 인스턴스 그 자체임
		//this.를 쓰는 이유는 변수명이 겹칠때 멤버필드나 메서드를 부르려고 함.
		
		if(index == -1) {
			return index;
			//삭제하려는 영화가 없으면 -1을 반환하여 main에서 출력
		}else {
			movies.remove(index);
			return 0;
			//삭제가 잘 됐으면 0을 반환하여 main에서 출력 
		}
	}
}