package example.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
/********************************************************************************
* File        : $Source:  $
* Version     : $Revision:  $
* Date        : $Date:  $
* Modified by : $Author:  $
*******************************************************************************
*/
public class PersonList extends PersonListAbstract
{
	public PersonList()
	{
		super();
	}

	public PersonList(int initialSize)
	{
		super(initialSize);
	}

	public PersonList(Collection c)
	{
		super(c);
	}

	public PersonList(Operation operation)
	{
		super(operation);
	}
}
