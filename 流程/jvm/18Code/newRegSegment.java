    /** Start a set of fresh registers.
     */
    public void newRegSegment() {
    DEBUG.P(this,"newRegSegment()");
    DEBUG.P("nextreg«∞="+nextreg);
    
	nextreg = max_locals;
	
	DEBUG.P("nextreg∫Û="+nextreg);
	DEBUG.P(0,this,"newRegSegment()");
    }