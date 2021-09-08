package chapter03;

public class SongTest {

	public static void main(String[] args) {
//		Song song = new Song();
//		song.setTitle("좋은날");
//		song.setArtist("아이유");
//		song.setAlbum("Real");
//		song.setComposer("이민수 작곡");
//		song.setYear(2010);
//		song.setTrack("3번 track");
		
		Song song1 = new Song("좋은날", "아이유", "이민수 작곡", "Real", 2010, "3번 track");
		song1.show();
		
		Song song2 = new Song("신호등", "\n이무진");
		song2.show();
	}

}
