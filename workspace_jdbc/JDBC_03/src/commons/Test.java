package commons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import students_DTO.MembersDTO;

public class Test {

	public static void main(String[] args) {

		// to_char(sysdate, 'YYYYMMDD HH:MI:SS');
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ hh:mm:ss");
		System.out.println(sdf.format(System.currentTimeMillis()));
		
		List<MembersDTO> list = new ArrayList<>();
		list.add(new MembersDTO("id1","pw1","name1","01012341234",null));
		list.add(new MembersDTO("id2","pw1","name1","01012341234",null));
		list.add(new MembersDTO("id3","pw1","name1","01012341234",null));
		list.add(new MembersDTO("id4","pw1","name1","01012341234",null));
		list.add(new MembersDTO("id5","pw1","name1","01012341234",null));
		list.stream().forEach(e -> System.out.printf("%s\t%s\t%s\t%s\n",e.getId(),e.getPw(),e.getName(),e.getContact()));
		System.out.println(list.stream().map(e -> e.getId()+"\t"+e.getPw()+"\t"+e.getName()+"\t"+e.getContact()+"\n").collect(Collectors.joining()));
	}

}
