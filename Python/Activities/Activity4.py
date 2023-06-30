while True:
    p1answer = str(input("Player1: Rock/Paper/Scissors?")).lower()
    p2answer = str(input("Player2: Rock/Paper/Scissors?")).lower()
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

    again = str(input("Want to play another round? Yes/No:")).lower()
    if again == 'yes':
        pass
    elif again == 'no':
        raise SystemExit
    else:
        print("Please enter a valid choice")
