/*
 * Copyright The Narayana Authors
 * SPDX short identifier: Apache-2.0
 */

package io.narayana.perf.product;

import javax.transaction.xa.XAResource;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.CommandLineOptionException;

//import com.arjuna.ats.jta.xa.performance.XAResourceImpl;

import com.arjuna.ats.arjuna.common.CoreEnvironmentBeanException;
import com.arjuna.ats.jta.xa.performance.JMHConfigJTA;
import com.ibm.tx.jta.TransactionManagerFactory;
import com.ibm.tx.jta.UserTransactionFactory;

import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.UserTransaction;



@State(Scope.Benchmark)
public class OpenLibertyComparison extends ProductComparisonJakarta {
    public static void main(String[] args) throws RunnerException, CommandLineOptionException, CoreEnvironmentBeanException {
        JMHConfigJTA.runJTABenchmark(OpenLibertyComparison.class.getSimpleName(), args);
    }

    protected ProductInterfaceJakarta getProductInterface() {
        return openLiberty;
    }

    private ProductInterfaceJakarta openLiberty = new ProductInterfaceJakarta() {
        private int count=0;
        private TransactionManager tm;
        private UserTransaction ut;
        @Override
        public UserTransaction getUserTransaction() throws SystemException {
            return ut;
        }

        @Override
        public TransactionManager getTransactionManager() {
            return tm;
        }

        @Override
        public String getName() {
            return "OpenLiberty";
        }

        @Override
        public XAResource getXAResource() {
            return new OpenLibertyXAResource();
        }

        @Override
        public void init() {
            tm = TransactionManagerFactory.getTransactionManager();
            ut = UserTransactionFactory.getUserTransaction();
        }
        @Override
        public void fini() {
        }

    };
}