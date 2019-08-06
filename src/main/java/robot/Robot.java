package robot;

public class Robot {
    private int x = 0;
    private int y = 0;
    private String direction = "n"; // n/s/w/e
    private static int LIMIT = 20;

    public void doAction(String action) {
        String subAction = "";
        for (int i = 0; i < action.length(); i++) {
            String actionLetter = (action.charAt(i) + "").toLowerCase();
            if ("l".equals(actionLetter) || "r".equals(actionLetter)) {
                move(subAction);
                subAction = "";
                getDirection(action.charAt(i) + "");
            } else if ("w".equals(actionLetter)) {
                move(subAction);
                subAction = "";
            } else if ("f".equals(actionLetter) || "b".equals(actionLetter)) {
                move(subAction);
                subAction = actionLetter;
            } else if (Character.isDigit(action.charAt(i))) {
                subAction += action.charAt(i) + "";
            }
        }
    }

    private void getDirection(String action) {
        if ("n".equals(direction)) {
            direction = "l".equals(action.toLowerCase()) ? "w" : "e";
        } else if ("s".equals(direction)) {
            direction = "l".equals(action.toLowerCase()) ? "e" : "w";
        } else if ("w".equals(direction)) {
            direction = "l".equals(action.toLowerCase()) ? "s" : "n";
        } else if ("e".equals(direction)) {
            direction = "l".equals(action.toLowerCase()) ? "n" : "s";
        } else {
            throw new RuntimeException("Unsupported action.");
        }
    }

    private void move(String action) {
        System.out.println(action);
        if ("".equals(action)) {
            return;
        }
        String moveDirection = "f".equals((action.charAt(0) + "").toLowerCase()) ? "f" : "b";
        int distance = Integer.parseInt(action.substring(1));
        if (distance >= LIMIT) {
            return;
        }
        if ("n".equals(direction)) {
            if ("f".equals(moveDirection) && y + distance < LIMIT) {
                y += distance;
            } else if ("b".equals(moveDirection) && y - distance >= 0) {
                y -= distance;
            }
        } else if ("s".equals(direction)) {
            if ("b".equals(moveDirection) && y + distance < LIMIT) {
                y += distance;
            } else if ("f".equals(moveDirection) && y - distance >= 0) {
                y -= distance;
            }
        } else if ("w".equals(direction)) {
            if ("b".equals(moveDirection) && x + distance < LIMIT) {
                x += distance;
            } else if ("f".equals(moveDirection) && x - distance >= 0) {
                x -= distance;
            }
        } else if ("e".equals(direction)) {
            if ("f".equals(moveDirection) && x + distance < LIMIT) {
                x += distance;
            } else if ("b".equals(moveDirection) && x - distance >= 0) {
                x -= distance;
            }
        }
    }

    public void showLocation() {
        System.out.println("x:" + x + "y:" + y + "direction:" + direction);
    }
}
