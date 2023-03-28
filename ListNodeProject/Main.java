package ListNodeProject;

public class Main {

	public static void main(String[] args){

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode lResult = addTwoNumbers(l1, l2);
        System.out.println(lResult.next.next.val);
        
	}

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int chiffre1 = l1.val;
        int chiffre2 = l2.val;
        int counter1 = 10;
        int counter2 = 10;
        while(l1.next != null){
            l1 = l1.next;
            chiffre1 += l1.val*counter1;
            counter1 = counter1*10;
        }
        while(l2.next != null){
            l2 = l2.next;
            chiffre2 += l2.val*counter2;
            counter2 = counter2*10;

        }
        int resultat = chiffre1 + chiffre2;
        int copyresultat = resultat;
        int potence = 1;
        int qtd = 1;
        while (copyresultat/10 != 0){
            copyresultat = copyresultat/10;
            potence = potence*10;
            ++qtd;
        }
        ListNode Head= new ListNode();
        Head.val = resultat%10;
        for(int i = 0; i < qtd -1; i ++){
            ListNode Noveau = new ListNode(resultat/(potence),Head.next);
            resultat = resultat%(potence);
            potence = potence/10;
            Head.next = Noveau;
        }
        return Head;
    }
}