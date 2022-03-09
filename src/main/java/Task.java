public class Task {

    Task(int player,int groups, int days){
//        int initialPlayers=Integer.parseInt(args[0]);
        int initialPlayers=player;
//        int groups;
        String keyword="Player";
        if(groups>0) {
//            groups = Integer.parseInt(args[1]);
            act(1,initialPlayers,keyword);
            keyword="Group";
            act(1,groups,keyword);
        }else{
            act(1,initialPlayers,keyword);
        }

        if(days>0){
            System.out.print("Rounds per day: ");
            if(groups>0 && days<groups-1 && groups%2!=0){
                System.out.println(groups-1/days);
            }else if(groups==0 && days<player-1 && player%2!=0){
                System.out.println(player-1/days);
            }else if((days>=groups && groups>0) || days>=player){
                System.out.println("1");
            }else if(days<groups-1 && groups%2==0){
                System.out.println((groups/days));
            }else if(groups==0 && days<player-1 && player%2==0){
                System.out.println((player/days));
            }
        }
    }

    public static void act(int groups, int initialPlayers, String keyword){
        int[] playerCount=new int[initialPlayers];
        for(int g=0;g<groups;g++){
            int players=initialPlayers;
            if(groups>1){
                System.out.println("Group "+(g+1));
            }
            getPlayers(playerCount,players);
            int extraPlayer=0;
            int flag=0;
            if(players%2!=0){
                flag=1;
                players=players-1;
                extraPlayer=players;

            }
            for(int i=0;i<players-1;i++){
                if(flag==0){
                    getFixture(i+1,players,playerCount,keyword);
                }else{
                    getFixture(i+1,players,playerCount,extraPlayer,keyword);
                }
                circle(playerCount,players);
                if(flag==1 && i==players-2){
                    System.out.println(keyword+" "+playerCount[i+1]+" vs "+keyword+" "+playerCount[extraPlayer]);
                }
            }
            System.out.println("\n");
        }
    }

    public static void getFixture(int r,int n, int[] array,String keyword){
        System.out.println("\nRound "+r);
        for(int i=0;i<n/2;i++){
            System.out.println(keyword+" "+array[i]+" vs "+keyword+" "+array[(n-1)-i]);
        }
    }

    public static void getFixture(int r,int n,int[] array,int player,String keyword){
        System.out.println("\nRound "+r);
        for(int i=0;i<n/2;i++){
            System.out.println(keyword+" "+array[i]+" vs "+keyword+" "+array[(n-1)-i]);
        }
        System.out.println(keyword+" "+array[player]+" vs "+keyword+" "+r);
    }

    public static void getPlayers(int[] array,int n){
        for(int i=0;i<n;i++){
            array[i]=i+1;
        }
    }

    public static void circle(int[] array,int n){
        int buffer=array[n-1];
        int secBuffer;
        for(int i=1;i<n;i++){
            secBuffer=array[i];
            array[i]=buffer;
            buffer=secBuffer;
        }
    }
}
