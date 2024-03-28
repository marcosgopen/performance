/*
 * Copyright The Narayana Authors
 * SPDX short identifier: Apache-2.0
 */

package io.narayana.perf.product;

import com.arjuna.ats.jta.xa.performance.XAResourceImpl;
import com.ibm.tx.jta.OnePhaseXAResource;


public class OpenLibertyXAResource extends XAResourceImpl implements OnePhaseXAResource {
    public String getResourceName() {
        return "OpenLiberty";
    }

}