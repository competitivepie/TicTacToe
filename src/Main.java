import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] gameGrid = new char[3][3];
        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[i].length; j++) {
                gameGrid[i][j] = ' ';
            }
        }
        System.out.println("---------");
        System.out.println("| "+gameGrid[0][0]+" "+gameGrid[0][1]+" "+gameGrid[0][2]+" |");
        System.out.println("| "+gameGrid[1][0]+" "+gameGrid[1][1]+" "+gameGrid[1][2]+" |");
        System.out.println("| "+gameGrid[2][0]+" "+gameGrid[2][1]+" "+gameGrid[2][2]+" |");
        System.out.println("---------");

        boolean isGameOver = false;
        char nextMove = 'X';
        int xCounter = 0;
        int oCounter = 0;
        int gapsLeft = 0;

        while (!isGameOver) {
            if(isGameOver) {  break; }
            // checking for rows
            for (int i = 0; i < gameGrid.length; i++) {
                if (gameGrid[i][0] == gameGrid[i][1] && gameGrid[i][0] == gameGrid[i][2]) {
                    if (gameGrid[i][0] == 'X') {
                        System.out.println("X wins");
                        isGameOver = true;
                        xCounter++;
                    }
                    if (gameGrid[i][0] == 'O') {
                        System.out.println("O wins");
                        isGameOver = true;
                        oCounter++;
                    }
                }
            }
            if ((xCounter >= 1 || oCounter >= 1) && xCounter == oCounter) {
                System.out.println("Impossible");
                isGameOver = true;
            }
            if (isGameOver) {
                break;
            }

            // checking for columns
            xCounter = 0;
            oCounter = 0;
            for (int j = 0; j < gameGrid.length; j++) {
                if (gameGrid[0][j] == gameGrid[1][j] && gameGrid[0][j] == gameGrid[2][j]) {
                    if (gameGrid[0][j] == 'X') {
                        System.out.println("X wins");
                        isGameOver = true;
                        xCounter++;
                    }
                    if (gameGrid[0][j] == 'O') {
                        System.out.println("O wins");
                        isGameOver = true;
                        oCounter++;
                    }
                }
            }
            if ((xCounter >= 1 || oCounter >= 1) && xCounter == oCounter) {
                System.out.println("Impossible");
                isGameOver = true;
                break;
            }
            if (isGameOver) {
                break;
            }

            // checking for diagonals
            if (gameGrid[0][0] == gameGrid[1][1] && gameGrid[0][0] == gameGrid[2][2]) {
                if (gameGrid[0][0] == 'X') {
                    System.out.println("X wins");
                    isGameOver = true;
                    break;
                }
                if (gameGrid[0][0] == 'O') {
                    System.out.println("O wins");
                    isGameOver = true;
                    break;
                }
            }
            if (gameGrid[0][2] == gameGrid[1][1] && gameGrid[0][2] == gameGrid[2][0]) {
                if (gameGrid[0][2] == 'X') {
                    System.out.println("X wins");
                    isGameOver = true;
                    break;
                }
                if (gameGrid[0][2] == 'O') {
                    System.out.println("O wins");
                    isGameOver = true;
                    break;
                }
            }

            // check if grid is filled
            for(int i = 0; i < gameGrid.length; i++) {
                for (int j = 0; j < gameGrid[i].length; j++) {
                    if (gameGrid[i][j] == ' ') {
                        gapsLeft++;
                        break;
                    }
                }
            }
            if (gapsLeft == 0) {
                System.out.println("Draw");
                isGameOver = true;
                break;
            }
            gapsLeft = 0;

            // allocating user input into game grid
            String userInput = sc.nextLine().trim();
            char[] inputArray = userInput.toCharArray();
            int xGrid, yGrid;
            if (Character.isDigit(inputArray[0]) && Character.isDigit(inputArray[1])) {
                xGrid = Character.getNumericValue(inputArray[0]);
                yGrid = Character.getNumericValue(inputArray[1]);
                if ((xGrid >= 1 && xGrid <= 3) && (yGrid >= 1 && yGrid <= 3)) {
                    if (gameGrid[xGrid - 1][yGrid - 1] == ' ') {
                        if (nextMove == 'X') {
                            gameGrid[xGrid - 1][yGrid - 1] = 'X';
                            nextMove = 'O';
                        } else if (nextMove == 'O') {
                            gameGrid[xGrid - 1][yGrid - 1] = 'O';
                            nextMove = 'X';
                        }
                        System.out.println("---------");
                        System.out.println("| "+gameGrid[0][0]+" "+gameGrid[0][1]+" "+gameGrid[0][2]+" |");
                        System.out.println("| "+gameGrid[1][0]+" "+gameGrid[1][1]+" "+gameGrid[1][2]+" |");
                        System.out.println("| "+gameGrid[2][0]+" "+gameGrid[2][1]+" "+gameGrid[2][2]+" |");
                        System.out.println("---------");
                    } else {
                        System.out.println("The cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
        sc.close();
    }
}

