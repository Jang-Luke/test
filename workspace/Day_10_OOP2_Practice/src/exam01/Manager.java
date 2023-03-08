package exam01;

import java.util.ArrayList;

public class Manager {

	private ArrayList <Movie> movies = new ArrayList<>();

	public void addMovie(Movie movie) {
		movies.add(movie);
	} // �ű� ��ȭ ��� ���

	public ArrayList <Movie> getMovies() {
		return movies;
	} // ��ȭ ��� ��ȯ ��� 

	public ArrayList<Movie> getMovies(String search) {
		// ��ȭ �˻� ��� 

		ArrayList <Movie> result = new ArrayList<>();

		for(Movie movie : movies) {
			if(movie.getMovieName().equals(search)) {//�˻� �Ϸ��� ������ ��ȭ���� ���� �� �͵���

				result.add(movie);//result ArrayList�� �Ű� ���� 	
			}	     
		}
		return result;	
	}
	public int getIndexByTitle(String search) { 
		//�迭�� �ε�����ȣ �����ϴ� �޼���
		for(int i = 0; i<movies.size(); i++) {
			
			if(movies.get(i).getMovieName().equals(search)) {
				
				return i; //��ȭ�� ã���� �ش� ��ȭ�� index ��ȯ 
			}	     
		}
		return -1; //��ȭ�� ã�� ���� �� -1 ��ȯ
	}
	public void updateByIndex (int index, Movie dst) { 
		//�������                          //������ �ν��Ͻ��� �Ѱܹ��� !
		
		movies.set(index, dst);
		
		//index : �迭�� ��ȣ
		//dst : �ٲ� ���� !!

	}
	public int deleteByTitle(String title) { 
		//�������
		
		int index = this.getIndexByTitle(title);
		//this. �� �ν��Ͻ� �� ��ü��
		//this.�� ���� ������ �������� ��ĥ�� ����ʵ峪 �޼��带 �θ����� ��.
		
		if(index == -1) {
			return index;
			//�����Ϸ��� ��ȭ�� ������ -1�� ��ȯ�Ͽ� main���� ���
		}else {
			movies.remove(index);
			return 0;
			//������ �� ������ 0�� ��ȯ�Ͽ� main���� ��� 
		}
	}
}