
import java.util.Random;


import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;


public class AgentX extends Agent{  
	
	private static final long serialVersionUID = 1L;

	@Override  
	protected void setup() {
		// TODO Auto-generated method stub
		System.out.println("je suis l'agent : " + this.getName());
		
		
		this.addBehaviour(new CyclicBehaviour() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				// TODO Auto-generated method stub 
				jade.lang.acl.ACLMessage msg = myAgent.receive();
				if(msg == null) this.block();
				else {
                        
							
						System.out.println("Moi<<<<"+ msg.getSender().getLocalName()+ msg.getContent());
					myAgent.addBehaviour(new CyclicBehaviour() {
						String mess = new String();
						Random rd = new Random(); 
						@Override
						public void action() {
							jade.lang.acl.ACLMessage msgr = new jade.lang.acl.ACLMessage(jade.lang.acl.ACLMessage.INFORM);
							int NN=rd.nextInt(1000);
							mess=String.valueOf(NN);
							msgr.addReceiver(msg.getSender());
							msgr.setContent(mess);
							System.out.println("Moi>>>>"+msg.getSender().getLocalName()+" : "+mess);
							myAgent.send(msgr);	
							myAgent.doWait(2000);
							
						}
						
					});
				}
						
			}
		});
		 
		//public void reponse
		
	}
	
	@Override
	protected void takeDown() {
		System.out.println("sa marche");
	}
	
	

	
}