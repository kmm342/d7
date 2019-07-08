package a1;

public class Person {
	/** String that represents the name of this person*/
	private String Name;
	/** The Person object for the mother of this person*/
	private Person mother;
	/** The Person object for the father of this person*/
	private Person father;
	/** The int for the year this person was born*/
	private int birthYear;
	/** The int for the month this person was born*/
	private int birthMonth;
	/** The int for the day this person was born*/
	private int birthDay;
	/** The int for the number of children this person has*/
	public int numChildren = 0;

	/**
	* @param Name string representing the name of this person.
	* @param birthYear int representing the year this person was born.
	* @param birthMonth int representing the month this person was born.
	* @param birthDay in representing the day this person was born.
	*/
	
	public Person(String name, int birthYear, int birthMonth, int birthDay) {
		//invariant: name must be non-null and non-empty
		assert name != null;
		assert name.length() != 0;
		this.Name = name;
		
		this.birthYear = birthYear;
		
		//invariant: Birth Month must be between [1...12]
		assert birthMonth >= 1 && birthMonth <= 12;
		this.birthMonth = birthMonth;
		
		//invariant: Birth Day must be between [1...31]
		assert birthDay >= 1 && birthDay <= 31;
		this.birthDay = birthDay;
	}
	
	public String name() {
		return Name;
	}
	
	public Person mother() {
		//return null if unknown
		if (this.mother == null) {
			return null;
		}
		else 
			return mother;
	}
	
	public Person father() {
		//return null if unknown
		if (this.father == null) {
			return null;
		}
		else
			return father;
	}
	
	public int birthYear() {
		return birthYear;
	}
	
	public int birthMonth() {
		return birthMonth;
	}
	
	public int birthDay() {
		return birthDay;
	}
	
	public int numChildren() {
		return numChildren;
	}

	/**Block B: Setters**/
	public void setName(String name) {
		Name = name;
		assert Name != null && Name.length() != 0;
	}
	
	public void setBirthYear(int y) {
		this.birthYear = y;
	}
	
	public void setBirthMonth(int m) {
		assert birthMonth >= 1 && birthMonth <= 12;
		this.birthMonth = m;
	}
	
	public void setBirthDay(int d) {
		assert birthDay >= 1 && birthDay <= 31;
		this.birthDay = d;
	}	

	public void setMother(Person m) {
		//if m is null, mother is unknown; so set 
		if(mother != null)
			mother.numChildren -= 1;
		if (m == null) 
			this.mother = null;
		else
			m.numChildren += 1;
			this.mother = m;
		
	}

	public void setFather(Person f) {
		//if f is null, father is unknown
		if(father != null)
			father.numChildren -= 1;
		if (f == null) 
			this.father = null;
		else
			f.numChildren += 1;
			this.father = f;
	}
	
	//precondition: other is non-null
	public boolean isHalfSibling(Person other) {
		assert other != null; //what does this check exactly? other.name, other.mother, other.father, etc?
		return (this.mother == other.mother ^ this.father == other.father);
	}
	
	public boolean isOlderThan(Person other) {
		return (this.birthYear < other.birthYear) 
				|| ((this.birthYear == other.birthYear) && (this.birthMonth < other.birthMonth))
				|| ((this.birthYear == other.birthYear) && (this.birthMonth == other.birthMonth) && (this.birthDay < other.birthMonth));
		}
	}
