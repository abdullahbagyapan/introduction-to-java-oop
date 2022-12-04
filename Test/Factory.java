package Test;

import java.util.HashMap;
import java.util.Map;

public class Factory extends Employee {
	public Factory(String name , String surname , int age , String job , String rank , int experience) {
		super(name, surname, age, job, rank, experience);
	}
	
	public static void main(String[] args) {
		Employee boss = new Employee("Abdullah","Bagyapan",18,"boss","test1",10);
		Employee emp1 = new Employee("xxx","yyy",20,"sales manager","test2",2);
		Employee emp2 = new Employee("mmm","kkk",22,"product manager","test3",4);
		
		System.out.println(boss.viewData());
		System.out.println(boss.rankSet("xxx yyy","test4"));
		System.out.println(boss.viewData());
		System.out.println(boss.Fire("mmm kkk"));
		System.out.println(boss.viewData());
		
		System.out.println(emp1.viewData());
		
	}

}


class Human{
	private String name , surname;
	private int age;
	private String full_name;
	
	public Human(String name , String surname , int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		full_name = this.name + " " + this.surname;
	}
	
	public String viewFullName() {
		return full_name;
	}
}


class Employee extends Human{
	private String job , rank;
	private int experience;
	private static int employeeNum;
	private static Map<String,String> data = new HashMap<>();
	
	public Employee(String name , String surname , int age , String job , String rank , int experience) {
		super(name, surname, age);
		this.job = job;
		this.rank = rank;
		this.experience = experience;
		Employee.data.put(super.viewFullName(),rank);
		Employee.employeeNum++;
	}
	
	public String rankSet(String full_name,String newRank) {
		if (this.job == "boss") {
			Employee.data.replace(full_name,newRank);
			return "Succesfully done";
		}
		else {
			return "You cant reach this attribute";
		}
	}
	
	public String Fire(String full_name) {
		if (this.job == "boss") {
			Employee.data.remove(full_name);
			Employee.employeeNum--;
			return "Succesfully done";
		}
		else {
			return "You cant reach this attribute";
		}
	}
	
	public String viewEmployeeNum() {
		if (this.job == "boss") {
			return String.format("%d",Employee.employeeNum);
		}
		else {
			return "You cant reach this attibute";
		}
	}
	
	
	public Map viewData() {
		if (this.job != "boss") {
			System.out.println("You cant reach this attribute");
		}		
		else {
			return Employee.data;
		}
		return null;
	}
}