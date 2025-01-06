# Library 

## Dossier out

`mkdir out`
`cd out`
`mkdir production`

## Compilation

### compile BookAPI

`javac -d out/production/BookAPI BookAPI/src/module-info.java BookAPI/src/packageBook/*.java`

### compile Checkout

`javac -d out/production/Checkout --module-path out/production Checkout/src/module-info.java Checkout/src/packageCheckout/*.java`

### compile Inventory

`javac -d out/production/Inventory --module-path out/production Inventory/src/module-info.java Inventory/src/packageInventory/*.java`

### compile Reports

`javac -d out/production/Reports --module-path out/production Reports/src/module-info.java Reports/src/packageReports/*.java`

### compile NotificationService

`javac -d out/production/NotificationService NotificationService/src/module-info.java NotificationService/src/packageNotification/*.java`

### compile SmsNotification

`javac -d out/production/SmsNotification --module-path out/production SmsNotification/src/module-info.java SmsNotification/src/packageSms/*.java`

### compile EmailNotification

`javac -d out/production/EmailNotification --module-path out/production EmailNotification/src/module-info.java EmailNotification/src/packageEmail/*.java`

### compile App

`javac -d out/production/App --module-path out/production App/src/module-info.java App/src/packageApp/*.java`

## Executer

### execute App

`java --module-path out/production --module out/production/App `