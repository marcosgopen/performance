package org.jboss.as.quickstarts.perf.jts.ejb;

import javax.ejb.Remote;

@Remote
public interface PerfTest2BeanRemote {

    long doWork(boolean enlist);
    long doWork();
}
