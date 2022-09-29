package Model;

public class User {
	private String name, surname, ID;

	public User(String name, String surname, String iD) {
		super();
		this.name = name;
		this.surname = surname;
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
}
