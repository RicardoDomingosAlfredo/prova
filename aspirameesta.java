import java.util.Scanner;

public class aspirameesta {

    public static void draw(int matrix[][], int v, int h, int counter, String bateria, int movidas, String basura) {
        System.out.println("+------------------------+");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i == v) && (j == h)) {
                    System.out.print("(O)");
                } else if (matrix[i][j] == 1) {
                    System.out.print("MMM");
                } else if (matrix[i][j] == 2) {
                    System.out.print(" . ");
                } else if (matrix[i][j] == 4) {
                    System.out.print(".o.");
                } else if (matrix[i][j] == 6) {
                    System.out.print("oOo");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+------------------------+");
        System.out.println("BATERIA: " + bateria);
        System.out.println("BASURA: " + basura);
        System.out.println("MOVIDAS: " + movidas);
        System.out.println("BASURA RESTANTE: " + counter);
        System.out.println("+------------------------+");
        System.out.println("OPCIONES:");
        System.out.println("Seguir: ENTER");
        System.out.println("Salir: Q");

    }

    public static double random() {
        double random = Math.floor((Math.random() * 4) + 1);
        return random;
    }

    public static Boolean clean(int matrix[][], int v, int h) {
        Boolean success = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((v == i) && (h == j)) {
                    if (matrix[i][j] == 6) {
                        matrix[i][j] = 4;
                        success = true;
                    } else if (matrix[i][j] == 4) {
                        matrix[i][j] = 2;
                        success = true;
                    } else if (matrix[i][j] == 2) {
                        matrix[i][j] = 0;
                        success = true;
                    }
                }

            }
        }
        return success;
    }

    public static int count(int matrix[][]) {
        int number = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((matrix[i][j] != 0) && (matrix[i][j] % 2 == 0)) {
                    number++;
                }
            }
        }
        return number;
    }

    public static String battery(int num) {
        String level = "";
        if ((num <= 100) && (num > 90)) {
            level = ("[Z/Z/Z/Z/Z/Z/Z/Z/Z/Z/]");
        } else if ((num <= 90) && (num > 80)) {
            level = ("[Z/Z/Z/Z/Z/Z/Z/Z/Z/  ]");
        } else if ((num <= 80) && (num > 70)) {
            level = ("[Z/Z/Z/Z/Z/Z/Z/Z/    ]");
        } else if ((num <= 70) && (num > 60)) {
            level = ("[Z/Z/Z/Z/Z/Z/Z/      ]");
        } else if ((num <= 60) && (num > 50)) {
            level = ("[Z/Z/Z/Z/Z/Z/        ]");
        } else if ((num <= 50) && (num > 40)) {
            level = ("[Z/Z/Z/Z/Z/          ]");
        } else if ((num <= 40) && (num > 30)) {
            level = ("[Z/Z/Z/Z/            ]");
        } else if ((num <= 30) && (num > 20)) {
            level = ("[Z/Z/Z/              ]");
        } else if ((num <= 20) && (num > 10)) {
            level = ("[Z/Z/                ]");
        } else if ((num <= 10) && (num > 0)) {
            level = ("[Z/                  ]");
        } else if (num == 0) {
            level = ("[                    ]");
        } else {
            level = ("[                    ]");
        }
        return level;
    }

    public static String can(int num) {
        String level = "";
        if (num == 0) {
            level = ("[                    ]");
        } else if (num == 1) {
            level = ("[*/                  ]");
        } else if (num == 2) {
            level = ("[*/*/                ]");
        } else if (num == 3) {
            level = ("[*/*/*/              ]");
        } else if (num == 4) {
            level = ("[*/*/*/*/            ]");
        } else if (num == 5) {
            level = ("[*/*/*/*/*/          ]");
        } else if (num == 6) {
            level = ("[*/*/*/*/*/*/        ]");
        } else if (num == 7) {
            level = ("[*/*/*/*/*/*/*/      ]");
        } else if (num == 8) {
            level = ("[*/*/*/*/*/*/*/*/    ]");
        } else if (num == 9) {
            level = ("[*/*/*/*/*/*/*/*/*/  ]");
        } else if (num == 10) {
            level = ("[*/*/*/*/*/*/*/*/*/*/]");
        } else {
            level = ("[*/*/*/*/*/*/*/*/*/*/]");

        }
        return level;
    }

    public static void main(String[] args) {

        Boolean jugando = true;
        Scanner in = new Scanner(System.in);

        int room[][] = {
                { 2, 2, 0, 0, 0, 4, 4, 6, },
                { 2, 0, 0, 0, 2, 0, 4, 4, },
                { 0, 0, 0, 0, 0, 0, 2, 1, },
                { 1, 2, 4, 1, 0, 2, 1, 1, },
                { 1, 0, 2, 1, 2, 2, 1, 1, },
                { 1, 2, 0, 1, 2, 0, 1, 1, },
                { 0, 0, 2, 4, 2, 2, 0, 1, },
                { 0, 2, 2, 4, 0, 0, 2, 0, },
                { 0, 2, 2, 0, 0, 0, 0, 0, },
        };

        int posAspV, posAspH;
        posAspV = 2;
        posAspH = 2;

        int min, maxY, maxH;
        min = 0;
        maxY = room.length - 1;
        maxH = room[0].length - 1;

        int movidas, bat, trashInMachine;
        movidas = 0;
        bat = 100;
        trashInMachine = 0;

        do {

            int trashInRoom = count(room);
            can(trashInMachine);

            draw(room, posAspV, posAspH, trashInRoom, battery(bat), movidas, can(trashInMachine));

            double movement = random();
            if ((movement == 1) && (posAspV < maxY) && (room[posAspV + 1][posAspH] % 2 != 1)) {
                posAspV++;
            } else if ((movement == 2) && (posAspV > min) && (room[posAspV - 1][posAspH] % 2 != 1)) {
                posAspV--;
            } else if ((movement == 3) && (posAspH < maxH) && (room[posAspV][posAspH + 1] % 2 != 1)) {
                posAspH++;
            } else if ((movement == 4) && (posAspH > min) && (room[posAspV][posAspH - 1] % 2 != 1)) {
                posAspH--;
            }

            if (clean(room, posAspV, posAspH) == true) {
                trashInMachine++;
            }

            String ask = in.nextLine();
            if (ask.equals("q")) {
                jugando = false;
            } else {
                movidas++;
                bat--;
            }

            if ((trashInRoom == 0) || (bat < 0) || (trashInMachine > 10)) {
                jugando = false;
            }

        } while ((jugando == true));

        in.close();
    }
}