import java.time.LocalDate;

public class stalls {
	int id;
	String name;
	LocalDate operationDate;
	
	public stalls(int id, String name, LocalDate operationDate) {
		super();
		this.id = id;
		this.name = name;
		this.operationDate = operationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(LocalDate operationDate) {
		this.operationDate = operationDate;
	}
	
}
