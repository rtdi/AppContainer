package io.rtdi.hanaappserver;

public enum ActivationSuccess {
	SUCCESS(0),
	WARNING(1),
	FAILED(99);

	private int prio;

	ActivationSuccess(int priority) {
		this.prio = priority;
	}
	
	public static ActivationSuccess aggregate(ActivationSuccess v1, ActivationSuccess v2) {
		if (v1 == null) {
			return v2;
		} else if (v2 == null) {
			return v1;
		} else if (v1.prio >= v2.prio) {
			return v1;
		} else {
			return v2;
		}
	}
}
