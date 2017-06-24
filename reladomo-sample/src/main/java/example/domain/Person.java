package example.domain;
import com.gs.fw.common.mithra.finder.Operation;

import java.sql.Timestamp;
/********************************************************************************
* File        : $Source:  $
* Version     : $Revision:  $
* Date        : $Date:  $
* Modified by : $Author:  $
*******************************************************************************
*/
public class Person extends PersonAbstract
{
	public Person()
	{
		super();
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}
	public String getFullName()
	{
		return this.getFirstName() + " " + getLastName();
	}

	public static void createPerson(String firstName, String lastName, String country)
	{
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setCountry(country);

		person.insert();
	}

	public static Person findPersonNamed(String firstName, String lastName)
	{
		Operation findByFirstNameAndLastName =
				PersonFinder.firstName().eq(firstName)
						.and(PersonFinder.lastName().eq(lastName));
		return PersonFinder.findOne(findByFirstNameAndLastName);
	}
}
