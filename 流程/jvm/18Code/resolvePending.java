    /** Resolve any pending jumps.
     */
    public void resolvePending() {
		DEBUG.P(this,"resolvePending()");
		DEBUG.P("pendingJumps«∞="+pendingJumps);
		
		Chain x = pendingJumps;
		pendingJumps = null;
		resolve(x, cp);
		
		DEBUG.P("pendingJumps∫Û="+pendingJumps);
		DEBUG.P(0,this,"resolvePending()");
    }