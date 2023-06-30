player1 = str(input("Player1: Rock/Paper/Scissors?"))
player2 = str(input("Player2: Rock/Paper/Scissors?"))
p1answer = player1.lower()
p2answer = player2.lower()
if p1answer == p2answer:
    print("Draw")
elif p1answer == 'rock':
    if p2answer == 'paper':
        print("Player 2 wins!")
    else:
        print("Player 1 wins!")
elif p1answer == 'paper':
    if p2answer == 'rock':
        print("Player 1 wins!")
    else:
        print("Player 2 wins!")
elif p1answer == 'scissors':
    if p2answer == 'paper':
        print("Player 1 wins!")
    else:
        print("Player 2 wins!")
else:
    print("Please enter a valid choice")
