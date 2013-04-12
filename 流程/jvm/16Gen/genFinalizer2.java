    /** Generate code to invoke the finalizer associated with given
     *  environment.
     *  Any calls to finalizers are appended to the environments `cont' chain.
     *  Mark beginning of gap in catch all range for finalizer.
     */
    void genFinalizer(Env<GenContext> env) {
	DEBUG.P(this,"genFinalizer(1)");
	DEBUG.P("env.info«∞="+env.info);

	if (code.isAlive() && env.info.finalize != null)
	    env.info.finalize.gen();

	DEBUG.P("env.info∫Û="+env.info);
	DEBUG.P(0,this,"genFinalizer(1)");
    }