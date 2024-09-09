import java.util.*;
class Publication
{
   double price;
   String title;
   int copies;
   double total;
Scanner sc=new Scanner(System.in);
public void settitle(String title) { 
    this.title=title;
}
public void setcopies(int copies)
{
this.copies=copies;
}
public String gettitle()
{
return title;
}
public double getTotal()
{
return total;
}
public int getCopies()
{
return copies; 
}
public double getprice() 
{
return price;
}
void read_publ()
{
System.out.print("enter title : ");
title=sc.next();
System.out.print("enter price: ");
price=sc.nextDouble();
System.out.print("enter copies: ");
copies=sc.nextInt();
}
void display()
{
System.out.print(title+"\t"+price+"\t"+copies);
}
void sale_copy(int number)
{
if (number <= copies)
{
copies=copies-number;
total=total+number*price;
System.out.println("\tYOU PURCHASED "+number +" COPIES \n\tYOU HAVE TO PAY : "+total);
}
else
System.out.println(" INSUFFICIENT STOCKK!!!!!!!!!");
}
}
class Book extends Publication
{
String author;
void order_copies(int number) {
int x=getCopies()+number;
setcopies(x);
System.out.println("\n\tORDER SUCESSFUL....");
System.out.println("\tCOPIES AVAILABLE : "+x);
}
void read_book() {
read_publ();
System.out.print("enter author book: ");
author=sc.next();
}
void display_book(){
System.out.println("title \tprice \tcopy \tauthor");
display();
System.out.println("\t"+author);
}
}
class Magazine extends Publication {
int ord_qty;
String issue_date;
void receive_issue(String new_issue_date) {
System.out.println("ENTER NEW COPIES ORDERED: ");
ord_qty=sc.nextInt();
setcopies(ord_qty);
issue_date=new_issue_date;
System.out.println("\tTHE MAGAZINE "+gettitle()+" \n\t WITH ISSUE DATE"+issue_date+"AVAILABLE");
}
void read_mag() {
read_publ();
System.out.print("Enter THe Current Issue Date [dd/mm/yyyy]");
issue_date=sc.next();
}
void display_mag() {
System.out.println("title \tprice \tcopy \tdate");
display();
System.out.println("\t"+issue_date);
}
}
public class publication{
public static void main(String[] args)
{
Book book = new Book();
Magazine magazine = new Magazine();

System.out.println("Enter details for the Book:");
book.read_book();
book.display_book();

System.out.print("\nEnter the number of copies to sell for the book: ");
Scanner sc = new Scanner(System.in);
int copiesToSell = sc.nextInt();
book.sale_copy(copiesToSell);

System.out.print("\nEnter the number of copies to order for the book: ");
int copiesToOrder = sc.nextInt();
book.order_copies(copiesToOrder);
book.display_book();

System.out.println("\nEnter details for the Magazine:");
magazine.read_mag();
magazine.display_mag();

System.out.print("\nEnter the number of copies to sell for the magazine: ");
int magazineCopiesToSell = sc.nextInt();
magazine.sale_copy(magazineCopiesToSell);

System.out.print("\nEnter the new issue date for the magazine: ");
String newIssueDate = sc.next();
magazine.receive_issue(newIssueDate);
magazine.display_mag();
sc.close();
}
}
