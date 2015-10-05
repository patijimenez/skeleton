import mx.gob.inadem.*

include "calls"
include "callTypes"

fixture {
	modality1(Modality){
		name = "Capacitación"
		hasChildren = false
		maxBudget = 40000000
		percentage = 50
		callToProposals = call1
    exclusionaryItems = true
    callType = callType1
	}
	modality2(Modality){
		name = "Consultoría"
		hasChildren = false
		maxBudget = 40000000
		percentage = 50
		callToProposals = call1
    exclusionaryItems = true
    callType = callType1
	}
	modality3(Modality){
		name = "Certificaciones"
		hasChildren = false
		maxBudget = 40000000
		percentage = 50
		callToProposals = call1
    exclusionaryItems = true
    callType = callType1
	}
	modality4(Modality){
		name = "Diseño e innovación"
		hasChildren = false
		maxBudget = 40000000
		percentage = 50
		callToProposals = call1
    exclusionaryItems = true
    callType = callType1
	}
	modality5(Modality){
		name = "Proyectos productivos integrales"
		hasChildren = true
		maxBudget = 40000000
		percentage = 50
		callToProposals = call2
    exclusionaryItems = true
    callType = callType1
	}
	modality6(Modality){
		name = "Proyectos de articulación estratégica y proyectos integrales de infraestructura"
		hasChildren = false
		maxBudget = 40000000
		percentage = 50
		callToProposals = call2
    exclusionaryItems = true
    callType = callType1
	}
	modality7(Modality){
		name = "Capacitación especializada"
		hasChildren = false
		maxBudget = 40000000
		percentage = 50
		parent = modality5
    exclusionaryItems = true
    callType = callType1
	}
	modality8(Modality){
		name = "Capacitación estructurada"
		hasChildren = false
		maxBudget = 5000000
		percentage = 50
		parent = modality5
    exclusionaryItems = true
    callType = callType1
	}
}
