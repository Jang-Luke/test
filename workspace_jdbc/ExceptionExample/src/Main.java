
public class Main {
	
	public static void main(String[] args) {
		try (Test test = new Test()) {
			System.out.println("start");
		} catch (Exception e) {
			System.out.println("end");
		}
	}
	
	private static class Test implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("closed");
		}
		
	}

}
