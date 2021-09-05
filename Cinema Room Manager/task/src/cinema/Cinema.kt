package cinema


fun main() {


    var price: Int
    var menuItem = -1
    var purchasedTickets = 0
    var income = 0
    val totalIncome: Int
    print("Enter the number of rows:\n> ")
    val rows = readLine()!!.toInt()
    print("Enter the number of seats in each row:\n> ")
    val seats = readLine()!!.toInt()
    val cinemaArr = Array(rows) { Array(seats) { "S" } }

    totalIncome = if (rows * seats <= 60) rows * seats * 10
    else (rows / 2 * seats * 10) + ((rows - rows / 2) * seats * 8)
    while (menuItem != 0) {

        print(
            """
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
        > 
    """.trimIndent()
        )
        menuItem = readLine()!!.toInt()
        when (menuItem) {
            1 -> {
                println("Cinema:")
                print(" ")
                for (s in 1..seats) {
                    print(" $s")
                }
                println()
                for (r in 0 until rows) {
                    print(r + 1)
                    for (s in 0 until seats) {
                        print(" ${cinemaArr[r][s]}")
                    }
                    println()

                }
            }
            2 -> {
                var isPurchased = false
                do {
                    print("Enter a row number:\n> ")
                    val rowNumber = readLine()!!.toInt()
                    print("Enter a seat number in that row:\n> ")
                    val seatNumber = readLine()!!.toInt()
                    println()
                    try {
                        if (cinemaArr[rowNumber - 1][seatNumber - 1] != "B") {
                            cinemaArr[rowNumber - 1][seatNumber - 1] = "B"
                            isPurchased = true
                            price = if (rows * seats <= 60) 10
                            else if (rowNumber <= rows / 2) 10
                            else 8
                            println("Ticket price: \$$price")
                            income += price
                            purchasedTickets++
                            println()
                        } else println("That ticket has already been purchased!\n")
                    } catch (e: Exception) {
                        println("Wrong input!\n")
                    }


                } while (!isPurchased)

            }
            3 -> {
                println("Number of purchased tickets: $purchasedTickets")
                val percentage = purchasedTickets.toDouble() / (rows.toDouble() * seats.toDouble()) * 100
                println("Percentage: ${String.format("%.2f", percentage)}%")
                println("Current income: $$income")
                println("Total income: $$totalIncome")

            }

        }

    }
}
