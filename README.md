# codealpha_task2
# Stock Trading Platform

This is a simple Java console application* that simulates stock trading.  
The user starts with a balance of $10,000 and can buy or sell stocks of popular companies like Apple, Google, Tesla, and Amazon.

---

## Features
- View current stock market prices  
- Buy stocks (if you have enough balance)  
- Sell stocks (if you own shares)  
- Track your portfolio (shares owned + remaining balance)  
- Exit anytime with final portfolio summary  

---

## How to Run
Clone or download this repository  
bash
git clone https://github.com/Md-Kajim/codealpha_task2.git

Go inside the project folder

cd codealpha_task2

Compile the Java file

javac StockTradingPlatform.java

Run the program

java StockTradingPlatform


---

Example Output

=== Stock Trading Menu ===
1. View Market Prices
2. Buy Stock
3. Sell Stock
4. View My Portfolio
5. Exit

Enter choice: 1
Market Prices:
Apple - $150
Google - $120
Tesla - $200
Amazon - $180

Enter choice: 2
Enter company name: Apple
Enter quantity: 5
Bought 5 shares of Apple

Enter choice: 4
Your Portfolio:
Apple - 5 shares (Value: $750.0)
Balance: $9250.0

Enter choice: 3
Enter company name: Apple
Enter quantity: 2
Sold 2 shares of Apple

Enter choice: 4
Your Portfolio:
Apple - 3 shares (Value: $450.0)
Balance: $9550.0

---

Author
Md-Kajim
