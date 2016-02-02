import mx.gob.inadem.*

fixture {
	callType1(CallType) {
		name = "Todo"
		typeDescription = "Todo prendido"
    generalData = true
    projectName = FieldShown.REQUIRED
    geographicCoverage = FieldShown.REQUIRED
    sectorsCoverage = FieldShown.REQUIRED
    eventAddress = FieldShown.REQUIRED
    executiveSummary = true
    objectives = FieldShown.REQUIRED
    description = FieldShown.REQUIRED
    calendar = FieldShown.REQUIRED
    justification = FieldShown.REQUIRED
    goals = true
    benefitingCompanies = FieldShown.REQUIRED
    newCompanies = FieldShown.REQUIRED
    preservedJobs = FieldShown.REQUIRED
    newJobs = FieldShown.REQUIRED
    attendedEntrepeneurs = FieldShown.REQUIRED
    freeBenefits = FieldShown.REQUIRED
    budget = true
    showBudget = FieldShown.REQUIRED
    inKindColaborations = FieldShown.REQUIRED
    beforeColaborations = FieldShown.REQUIRED
	}
}

