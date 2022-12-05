package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import DonationFactory.CancerDonationFactory;
import DonationFactory.SchoolDonationFactory;
import Handlers.FileHandler;
import MobileInternetFactory.EtisalatFactory;
import MobileInternetFactory.VodafoneFactory;
import MobileInternetFactory.VodafoneInternetPayment;
import Transaction.ITransaction;
import Transaction.PaymentTransaction;
import Transaction.WalletTransaction;
import landlineFactory.MonthlyLandlineFactory;
import landlineFactory.MonthlyReciept;
import landlineFactory.QuarterLandlineFactory;
import users.IPerson;
import users.User;
import users.UserManage;

public class main {

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("1.User.\n2.Admin.\n3.Exit");
			System.out.print("\nchoice : ");
			Scanner in=new Scanner(System.in);
			choice =in.nextInt();
			switch(choice) {
				// user
				case 1 :{
					int choice2;
					do {
						System.out.println("\n\t-- USER MENU --\t\n");
						System.out.println("1.SignUp.\n2.Sign in.\n3.Back");
						System.out.print("\nchoice : ");
						choice2=in.nextInt();
						User user;
						UserManage userManage;
						switch(choice2){
						// sign up
						case 1:{
							in=new Scanner(System.in);
							System.out.print("->Username : ");
							String userName=in.nextLine();
							System.out.print("->Email : ");
							String email=in.nextLine();
							System.out.print("->Password : ");
							String password=in.nextLine();
							System.out.print("->CreditCard Number : ");
							String creditNumber=in.nextLine();
							System.out.print("->amount : ");
							double amount=in.nextDouble();
//							creating user
							user=new User(userName,email,password,creditNumber,amount);
							userManage=new UserManage(user);
							try {
								if(userManage.signUp()) {
									System.out.println("signed up successfully :)");
								}	else {
									System.out.println("username or email already exists");
									break;
								}
							}catch(IOException e) {
								e.printStackTrace();
							}
							break;
						}
//						sign in
						case 2:{
							in=new Scanner(System.in);
							System.out.print("->Email : ");
							String email=in.nextLine();
							System.out.print("->Password : ");
							String password=in.nextLine();
							user=new User("",email,password,"",0);
							userManage=new UserManage(user);
							try {
								if(userManage.signIn()) {
									System.out.println("signed in");
									System.out.println(user.getUserName());
									System.out.println(user.getCreditCard().getAmount());
								}else {
									System.out.println("invalid email or password");
									break;
								};
							}catch(IOException e) {
								e.printStackTrace();
							}
//							while the user is logged in do
							do {
								System.out.println("-------------------");
								System.out.println("1.Normal Transaction.\n2.Add To Wallet Transaction.\n3.Request Refund Transaction\n4.Sign Out");
								System.out.println("-------------------");
								System.out.print("\nchoice : ");
								in =new Scanner(System.in);
								int choice3 = in.nextInt();
								switch(choice3) {
								case 1 :{
									PaymentTransaction t=new PaymentTransaction(user);
									int choice4;
									do{
										System.out.println("\n1.Internet Payment.\n2.Mobile Recharge.\n3.Landline Pay.\n4.Donations.");
										System.out.print("Choice : ");
										in=new Scanner(System.in);
										choice4=in.nextInt();
										switch(choice4) {
											case 1 :{
												int internetChoice;
												do {
													System.out.println("\n1.Vodafone Internet Payment.\n2.1.Etisalat Internet Payment.\n3.Cancel.\n");
													System.out.print("Choice : ");
													in=new Scanner(System.in);
													internetChoice=in.nextInt();
													switch(internetChoice) {
													case 1:{
														t.setInternetPayment(new VodafoneFactory().createInternetService());
														t.submit();
														break;
													}
													case 2:{
														t.setInternetPayment(new EtisalatFactory().createInternetService());
														t.submit();
														break;
													}
													case 3:{
														internetChoice=10;
														break;
													}
													default : {
														System.out.println("invalid choice");
														internetChoice=1;
													}
													}
												}while(internetChoice>0&&internetChoice<3);
												break;
											}
											case 2 :{
												int mobileChoice;
												do {
													System.out.println("\n1.Vodafone Mobile Recharge.\n2.1.Etisalat Mobile Recharge.\n3.Cancel.\n");
													System.out.print("Choice : ");
													in=new Scanner(System.in);
													mobileChoice=in.nextInt();
													switch(mobileChoice) {
													case 1:{
														t.setMobileRecharge(new VodafoneFactory().createMobileService());
														t.submit();
														break;
													}
													case 2:{
														t.setMobileRecharge(new EtisalatFactory().createMobileService());
														t.submit();
														break;
													}
													case 3:{
														mobileChoice=10;
														break;
													}
													default : {
														System.out.println("invalid choice");
														mobileChoice=1;
													}
													}
												}while(mobileChoice>0&&mobileChoice<3);
												break;
											}
											case 3 :{
												int landlineChoice;
												do {
													System.out.println("\n1.Monthly Landline Reciept.\n2.Quarter Landline Reciept.\n3.Cancel.\n");
													System.out.print("Choice : ");
													in=new Scanner(System.in);
													landlineChoice=in.nextInt();
													switch(landlineChoice) {
													case 1:{
														t.setLandline(new MonthlyLandlineFactory().createLandline());
														t.submit();
														break;
													}
													case 2:{
														t.setLandline(new QuarterLandlineFactory().createLandline());
														t.submit();
														break;
													}
													case 3:{
														landlineChoice=10;
														break;
													}
													default : {
														System.out.println("invalid choice");
														landlineChoice=1;
													}
													}
												}while(landlineChoice>0&&landlineChoice<3);
												break;
											}
											case 4 :{
												int donationChoice;
												do {
													System.out.println("\n1.School Donation.\n2.Cancer Donation.\n3.Cancel.\n");
													System.out.print("Choice : ");
													in=new Scanner(System.in);
													donationChoice=in.nextInt();
													switch(donationChoice) {
													case 1:{
														t.setDonation(new SchoolDonationFactory().createDonation());
														t.submit();
														break;
													}
													case 2:{
														t.setDonation(new CancerDonationFactory().createDonation());
														t.submit();
														break;
													}
													case 3:{
														donationChoice=10;
														break;
													}
													default : {
														System.out.println("invalid choice");
														donationChoice=1;
													}
													}
												}while(donationChoice>0&&donationChoice<3);
												break;
											}
										}

									}while(choice4>0&&choice4<5);																	}
								case 2 :{
									in=new Scanner(System.in);
									System.out.print("Enter amount to add in wallet : ");
									Double amount=in.nextDouble();
									ITransaction t=new WalletTransaction(user,amount);
									t.submit();
									break;
								}
								case 4:{
									userManage.signOut();
									break;
								}
								default:{
									System.out.println("invalid choice");
								}
								}
							}while(user.getIsLoggedIn());
							break;
						}
//						back
						case 3:{
							choice2=10;
							break;
						}
						default:{
							System.out.println("Invalid choice");
							choice2=1;
							break;
						}
						}
						
					}while(choice2>0&&choice2<4);
					break;
				}
//				exit
				case 3 :{
					return;
				}
				default:{
					System.out.println("Invalid choice");
					choice=1;
					continue;
				}
			}
		}while( choice>0 && choice<3 );		
		
		
				
		
		
		return;
	}

}
