

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;


public class AgentY extends Agent{  
	
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
						int i=0;
						@Override
						public void action() {
							if (!(msg.getContent().equals(" Donnez moi vos résultats"))) {
								i=Integer.valueOf(msg.getContent());
							}
							i++;
							mess=String.valueOf(fctn(i));
							jade.lang.acl.ACLMessage msgr = new jade.lang.acl.ACLMessage(jade.lang.acl.ACLMessage.INFORM);
							
							msgr.addReceiver(msg.getSender());
							msgr.setContent(mess);
							System.out.println("Moi>>>>"+msg.getSender().getLocalName()+" : "+mess);
							myAgent.send(msgr);	
							myAgent.doWait(4000);
							
						}
						public int fctn(int m) {
							return (3*m*m+5*m+9);
							
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