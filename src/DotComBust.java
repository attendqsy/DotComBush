import java.util.ArrayList;

public class DotComBust {
    //声明并初始化变量
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        //创建3个DotCom对象并指派名称并置入ArrayList
        DotCom one = new DotCom();
        one.setName("qgt.com");
        DotCom two = new DotCom();
        two.setName("qsy.com");
        DotCom three = new DotCom();
        three.setName("yz.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        //列出简短的提示
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("qgt.com, qsy.com, yz.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (DotCom dotComToSet : dotComsList) {//对list中的每个DotCom重复一次
            ArrayList<String> newLocation = helper.placeDotCom(3);//要求DotCom的位置
            dotComToSet.setLocationCells(newLocation);//调用这个DotCom的setter方法来指派刚取得的位置
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {//判断DotCom的list是否为空
            String userGuess = helper.getUserInput("Enter a guess");//取得玩家输入
            checkUserGuess(userGuess);//调用checkUserGuess方法
        }
        finishGame();//调用finishGame方法
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        for (DotCom dotComToTest :
                dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your Stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough." + numOfGuesses + " guesses");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
