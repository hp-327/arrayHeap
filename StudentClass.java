package p9_package;

public class StudentClass
{
	char gender;
	double gpa;
	String name ;
	int	studentID ;
	
	/**
	 * Initialization constructor for data
	 * Note: Class does not require a default constructor
	 * @param inName - name of student to be input into object
	 * @param inStudentID- ID number of student to be input into object
	 * @param inGender - gender of student to be input into object
	 * @param inGPA- gpa of student to be input into object
	 */
	public StudentClass(String inName,
            int inStudentID,
            char inGender,
            double inGPA)
	{
		name = inName;
		studentID = inStudentID;
		gender = inGender;
		gpa = inGPA;
	}
	/**
	 * Copy constructor
	 * Calls other constructor with copied data
	 * @param copied - StudentClass object to be copied
	 */
	public StudentClass(StudentClass copied)
	{/**
		this.studentID = copied.studentID;
		this.gender = copied.gender;
		this.gpa = copied.gpa;
		*/
		this(copied.name, copied.studentID, copied.gender, copied.gpa);
		
	}
	/**
	 * Compares student objects
	 * Note: Compares gpa as class key; returns integer 
	 * result such that if this gpa 
	 * is less than other gpa, a negative number is returned; 
	 * if this gpa is greater 
	 * than other gpa, a positive number is returned; 
	 * if this gpa is equal to other gpa, 
	 * zero is returned
	 * Note: difference precision is 0.00001
	 * @param other- StudentClass object to be compared with this object
	 * @return-integer difference between gpa grades
	 * 
	 */
	public int compareTo(StudentClass other)
	{
		double diff;
			diff = gpa - other.gpa;
			return (int) (100000 * diff);
	}
	/**
	 * Overrides Object toString with local
	 * Overrides: toString in class java.lang.Object
	 */
	public String toString()
	{
		return (name +'/'+studentID+'/' + gender + '/' + gpa );
	}
	

}
