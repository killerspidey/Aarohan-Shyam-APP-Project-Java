# Currency Converter Project

# Define exchange rates relative to USD
exchange_rates = {
    "USD": 1.0,
    "INR": 82.75,  # 1 USD = 82.75 INR
    "EUR": 0.91,   # 1 USD = 0.91 EUR
    "GBP": 0.79,   # 1 USD = 0.79 GBP
    "JPY": 147.5   # 1 USD = 147.5 JPY
}

def convert_currency(amount, from_currency, to_currency):
    # Convert from source currency to USD
    amount_in_usd = amount / exchange_rates[from_currency]
    # Convert from USD to target currency
    converted_amount = amount_in_usd * exchange_rates[to_currency]
    return converted_amount

def main():
    print("Welcome to Currency Converter")
    print("Available currencies: USD, INR, EUR, GBP, JPY")
    
    try:
        amount = float(input("Enter amount to convert: "))
    except ValueError:
        print("Invalid amount. Please enter a number.")
        return
    
    from_currency = input("From currency (e.g. USD): ").upper()
    to_currency = input("To currency (e.g. INR): ").upper()

    if from_currency not in exchange_rates:
        print(f"Currency '{from_currency}' not supported.")
        return
    if to_currency not in exchange_rates:
        print(f"Currency '{to_currency}' not supported.")
        return

    result = convert_currency(amount, from_currency, to_currency)
    print(f"{amount} {from_currency} is equal to {result:.2f} {to_currency}")

if __name__ == "__main__":
    main()
