package zkLearn;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.*;

public class Master implements Watcher {
	ZooKeeper zk;
	String hostPort;

	
	Master(String hostPort) {
		this.hostPort = hostPort;
	}
	
	void startZK() {
		try {
			zk = new ZooKeeper(hostPort, 15000, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void process(WatchedEvent e){
		System.out.println(e);
	}

	public static void main(String[] args) 
		throws Exception {
			Master m = new Master(args[0]);
			
			m.startZK();
			
			Thread.sleep(60000);
		}

}
