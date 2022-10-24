
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;


public class JadeTP extends Agent{  
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		System.out.println("je suis l'agent : " + this.getName());
		
		
		jade.lang.acl.ACLMessage msg = new jade.lang.acl.ACLMessage(jade.lang.acl.ACLMessage.INFORM);
		
		msg.addReceiver(new AID("wissem",AID.ISLOCALNAME));
		msg.setContent(" Donnez moi vos résultats");
		this.send(msg);
		
jade.lang.acl.ACLMessage msg2 = new jade.lang.acl.ACLMessage(jade.lang.acl.ACLMessage.INFORM);
		
		msg2.addReceiver(new AID("merouane",AID.ISLOCALNAME));
		
		msg2.setContent(" Donnez moi vos résultats");
		this.send(msg2);
		
        this.addBehaviour(new SimpleBehaviour() {
			
			@Override
			public boolean done() {
				// TODO Auto-generated method stub
				return false;
			}
			int num1=0,num2=0;
			@Override
			public void action() {
				jade.lang.acl.ACLMessage msg = myAgent.receive();
				if(msg == null) this.block();
				else {
					String mysender = msg.getSender().getLocalName();
					System.out.println("Moi<<<<"+msg.getSender().getLocalName()+" : "+msg.getContent());
					
					
					
					if (mysender.equals("wissem")) {
						num1 = Integer.valueOf(msg.getContent());
						
						
					}
					if (mysender.equals("merouane")) {
						num2 = Integer.valueOf(msg.getContent());
						
					}
					System.out.println("le maximum est : "+Math.max(num1, num2));
				}
			}
		});
	}
	
	@Override
	protected void takeDown() {
		System.out.println("sa marche");
	}
	
	

	
}