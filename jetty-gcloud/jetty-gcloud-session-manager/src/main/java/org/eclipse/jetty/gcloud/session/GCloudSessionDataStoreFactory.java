//
//  ========================================================================
//  Copyright (c) 1995-2016 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//


package org.eclipse.jetty.gcloud.session;

import org.eclipse.jetty.server.session.AbstractSessionDataStoreFactory;
import org.eclipse.jetty.server.session.SessionDataStore;
import org.eclipse.jetty.server.session.SessionHandler;

/**
 * GCloudSessionDataStoreFactory
 *
 *
 */
public class GCloudSessionDataStoreFactory extends AbstractSessionDataStoreFactory
{
    private GCloudConfiguration _config;
    private int _maxRetries;
    private int _backoffMs;
    
    
    public GCloudConfiguration getGCloudConfiguration()
    {
        return _config;
    }

    public void setGCloudConfiguration(GCloudConfiguration config)
    {
        _config = config;
    }

    public int getMaxRetries()
    {
        return _maxRetries;
    }

    public void setMaxRetries(int maxRetries)
    {
        _maxRetries = maxRetries;
    }

    public int getBackoffMs()
    {
        return _backoffMs;
    }

    public void setBackoffMs(int backoffMs)
    {
        _backoffMs = backoffMs;
    }

    
    /** 
     * @see org.eclipse.jetty.server.session.SessionDataStoreFactory#getSessionDataStore(org.eclipse.jetty.server.session.SessionHandler)
     */
    @Override
    public SessionDataStore getSessionDataStore(SessionHandler handler) throws Exception
    {
        GCloudSessionDataStore ds = new GCloudSessionDataStore();
        ds.setGCloudConfiguration(getGCloudConfiguration());
        ds.setBackoffMs(getBackoffMs());
        ds.setMaxRetries(getMaxRetries());
        ds.setGracePeriodSec(getGracePeriodSec());
        return ds;
    }

}
