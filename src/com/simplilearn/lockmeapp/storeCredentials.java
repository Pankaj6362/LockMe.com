package com.simplilearn.lockmeapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class storeCredentials {
	
	public static void main(String[] args) throws IOException {
		
		welcome();
		ogIn();
	}

	public static void welcome(){
		System.out.println("---------------------------");
		System.out.println("     -  WELCOME  -");
		System.out.println("---------------------------");
	}
	public static void ogIn () throws IOException {
		System.out.println("1 - Registration");
		System.out.println("2 - Login");
		Scanner typeNum = new Scanner(System.in);
		int num = typeNum.nextInt();
		if (num!=2) {
			System.out.println("------------------------------------");
			System.out.println("- Welcome To Registration Process -");
			System.out.println("------------------------------------");
			
			
			
			Scanner regUser = new Scanner(System.in);
			System.out.println("Username :");
			String register = regUser.nextLine();
			
			Scanner regLogin = new Scanner(System.in);
			System.out.println("Password :");
			String logIn = regLogin.nextLine();
			
			File fileObj = new File("UserInfo.txt");
			try {
				fileObj.createNewFile();
				if (fileObj.exists()) {
					FileWriter fileWriter = new FileWriter(fileObj);
					fileWriter.write(register);
					fileWriter.write(logIn);
					fileWriter.close();
				} else {
					throw new FileNotFoundException("file is not available: "+fileObj.getName());
				}
			} catch (Exception e) {
				System.out.println("An error occured");
			}
			
			System.out.println("Thank You !!");
		}else {
			System.out.println("----------------------------");
			System.out.println("- Welcome To LogIn Process -");
			System.out.println("----------------------------");
			
			Scanner logUsername = new Scanner (System.in);
			System.out.println("Username :" +logUsername);
			String logInUser = logUsername.nextLine();
			
			Scanner logPassword = new Scanner (System.in);
			System.out.println("Password :" +logPassword);
			String logInPass = logPassword.nextLine();
			UserLogIn();
			}
		
			
		}
	   private static void UserLogIn() throws IOException {
			System.out.println("--------------------------");
			System.out.println("- Welcome To Your Profile -");
			System.out.println("--------------------------");
			
			System.out.println("1 - Store credentials");
			System.out.println("2 - See your Stored Credentials");
			Scanner typeNum1 = new Scanner(System.in);
			int num1 = typeNum1.nextInt();
			File fileObj1 = new File("UserDatabase.txt");
			if (num1 !=2) {
				Scanner storeAccountName = new Scanner(System.in);
				System.out.println("Account Name :");
				String accName = storeAccountName.nextLine();
				
				Scanner storeUserName = new Scanner(System.in);
				System.out.println("User Name :");
				String usrName = storeUserName.nextLine();
				
				Scanner storePassword = new Scanner(System.in);
				System.out.println("Password :");
				String usrPass = storePassword.nextLine();
				
				
				
				try {
					fileObj1.createNewFile();
					fileObj1.canRead();
					if(fileObj1.exists()) {
						FileWriter FileWriter1 = new FileWriter(fileObj1, true);
						FileWriter1.write("Account Name :"+accName);
						FileWriter1.write("User Name :"+usrName);
						FileWriter1.write("Password :"+usrPass);
						FileWriter1.close();
					}else {
						throw new FileNotFoundException("file is not available: "+fileObj1.getName());
					}
					
				} catch (Exception e) {
					System.out.println("An error occured");
				}
				
				System.out.println("Thank You !!");
			}else {
				FileReader FileReader = new FileReader(fileObj1);
				System.out.println(FileReader);
				FileReader.close();
			}
		
	}
}
