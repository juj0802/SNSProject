package dao;

public class UserDto {
	private String id,name,regDt;

	public UserDto(String id, String name, String regDt) {
		
		this.id = id;
		this.name = name;
		this.regDt = regDt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

}
