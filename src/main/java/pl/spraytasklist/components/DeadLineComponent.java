package pl.spraytasklist.components;

import org.springframework.stereotype.Component;

@Component
public class DeadLineComponent {
		
	public String convertToString(Long eta) {
		
		StringBuilder sb = new StringBuilder();
		
		if(eta < 0)
			sb.append("Delayed: ");
		
		eta = Math.abs(eta);
		int days = (int) (eta / 86400);
		int temp = (int) (eta - days * 86400);
	    int hours = temp / 3600;
	    temp = temp - hours * 3600;
	    int mins = temp / 60;
	    temp = temp - mins * 60;
	    int secs = temp;
	    
	    
	    
	    if(days > 1)
	    	sb.append(days + " days ");
	    else if (days == 1)
	    	sb.append(days + " day ");
	   
	    
	    if(hours < 10)
	    	sb.append("0" + hours + ":");
	    else
	    	sb.append(hours + ":");
	    
	    if(mins < 10)
	    	sb.append("0" + mins + ":");
	    else
	    	sb.append(mins + ":");
	    
	    if(secs < 10)
	    	sb.append("0" + secs);
	    else
	    	sb.append(secs);
	    
		return sb.toString();
	}
	
}
