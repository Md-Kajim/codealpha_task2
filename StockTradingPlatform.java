import java.util.*;

// Stock class to hold company name and price
class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Portfolio class to track user holdings
class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();
    private double balance = 10000; // Starting balance

    // Buy stock
    void buy(Stock stock, int qty) {
        double cost = stock.price * qty;
        if (balance >= cost) {
            balance -= cost;
            holdings.put(stock.name, holdings.getOrDefault(stock.name, 0) + qty);
            System.out.println(" Bought " + qty + " shares of " + stock.name);
        } else {
            System.out.println("Not enough balance to buy!");
        }
    }

    // Sell stock
    void sell(Stock stock, int qty) {
        int owned = holdings.getOrDefault(stock.name, 0);
        if (owned >= qty) {
            balance += stock.price * qty;
            holdings.put(stock.name, owned - qty);
            System.out.println("✅Sold " + qty + " shares of " + stock.name);
        } else {
            System.out.println(" You don't have enough shares!");
        }
    }

    // Show portfolio
    void show(List<Stock> market) {
        System.out.println("\n Your Portfolio:");
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            String name = entry.getKey();
            int qty = entry.getValue();
            double price = 0;
            for (Stock s : market) {
                if (s.name.equals(name)) {
                    price = s.price;
                    break;
                }
            }
            System.out.println(name + " - " + qty + " shares (Value: $" + (qty * price) + ")");
        }
        System.out.println(" Balance: $" + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Stock market data
        List<Stock> market = Arrays.asList(
            new Stock("Apple", 150),
            new Stock("Google", 120),
            new Stock("Tesla", 200),
            new Stock("Amazon", 180)
        );

        Portfolio pf = new Portfolio();

        while (true) {
            System.out.println("\n=== Stock Trading Menu ===");
            System.out.println("1. View Market Prices");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View My Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.println("\n Market Prices:");
                for (Stock s : market) {
                    System.out.println(s.name + " - $" + s.price);
                }
            } else if (ch == 2) {
                System.out.print("Enter company name: ");
                String name = sc.next();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                boolean found = false;
                for (Stock s : market) {
                    if (s.name.equalsIgnoreCase(name)) {
                        pf.buy(s, qty);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println(" Stock not found!");
            } else if (ch == 3) {
                System.out.print("Enter company name: ");
                String name = sc.next();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                boolean found = false;
                for (Stock s : market) {
                    if (s.name.equalsIgnoreCase(name)) {
                        pf.sell(s, qty);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println(" Stock not found!");
            } else if (ch == 4) {
                pf.show(market);
            } else if (ch == 5) {
                System.out.println(" Thanks for trading!");
                break;
            } else {
                System.out.println(" Invalid choice, try again!");
            }
        }
        sc.close();
    }
}