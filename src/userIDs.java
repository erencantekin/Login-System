import java.util.ArrayList;
import java.util.HashMap;

public class userIDs {
	public static HashMap<String,ArrayList> user_id = new HashMap<>();
	
	ArrayList<String> arr = new ArrayList<String>();
	
	userIDs(String username, String password, String email, String age, boolean gender){
		arr.add(username);
		arr.add(password);
		arr.add(email);
		arr.add(age);
		if(gender) {
			arr.add("Female");
		}
		else {
			arr.add("Male");
		}
		
		user_id.put(username, arr);
	}
}
