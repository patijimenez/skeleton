class UrlMappings {

	static mappings = {
		
    "/api/v1/healthCheck/$action" {
      controller = 'apiHealthCheck'		
    }

  	"/api/v1/appConfig/$action"{
			controller = 'apiAppConfig'
			// action = 'loggedIn'
		}

  	"/api/v1/profile/$action"{
			controller = 'apiProfile'
			// action = 'loggedIn'
		}

  	"/api/v1/catalog/$action"{
			controller = 'apiCatalog'
			// action = 'loggedIn'
		}
	  
    "/api/v1/application/$action"{
			controller = 'apiApplication'
		}

    "/api/v1/document/$action"{
			controller = 'apiDocument'
		}

    "/api/v1/developer/$action"{
			controller = 'apiDeveloper'
		}
	  
    "/api/v1/call/$action"{
			controller = 'apiCall'
		}

    "/api/v1/guider/$action"{
			controller = 'apiGuider'
		}

    "/api/v1/modality/$action"{
			controller = 'apiModality'
		}

  	"/api/v1/auth/$action"{
			controller = 'apiAuth'
			// action = 'loggedIn'
		}

  	"/api/v1/status/$action"{
			controller = 'apiStatus'
			// action = 'loggedIn'
		}

  	"/api/v1/councilEvaluation/$action"{
			controller = 'apiCouncilEvaluation'
			// action = 'loggedIn'
		}

  	"/api/v1/evaluation/$action"{
			controller = 'apiEvaluation'
			// action = 'loggedIn'
		}

  	"/api/v1/fiel/$action"{
			controller = 'apiFiel'
			// action = 'loggedIn'
		}

  	"/api/v1/message/$action"{
			controller = 'apiMessage'
			// action = 'loggedIn'
		}

  	"/api/v1/task/$action"{
			controller = 'apiTask'
			// action = 'loggedIn'
		}
	
	"/api/v1/installationSession/$action"{
		  controller = 'apiInstallationSession'
		  // action = 'loggedIn'
	  	}

    "/api/v1/assignment/$action"{
          controller = 'apiAssignment'
          // action = 'loggedIn'
        }

    "/api/v1/job/$action"{
          controller = 'apiJob'

    }

    "/api/v1/legalDocument/$action"{
        controller = 'apiLegalDocument'

    }

    "/api/v1/accreditation/$action"{
        controller = 'apiAccreditation'

    }

    "/api/v1/ministration/$action"{
      controller = 'apiMinistration'

    }

    "/api/v1/documentGenerator/$action"{
      controller = 'apiDocumentGenerator'

    }

    "/api/v1/legalRequirements/$action"{
        controller = 'apiLegalRequirements'
    }

    "/api/v1/agreements/$action"{
        controller = 'apiAgreement'
    }

    "/api/v1/users/$action" {
      controller = 'apiUser'
    }

    "/api/v1/complaint/$action"{
      controller = 'apiComplaint'
    }

    "/api/v1/responseComplaint/$action"{
      controller = 'apiResponseComplaint'
    }

    "/api/v1/tracking/$action"{
      controller = 'apiTracking'
    }

    "/api/v1/survey/$action"{
      controller = 'apiSurvey'
    }

    "/api/v1/analysisGroup/$action" {
      controller = 'apiAnalysisGroup'
    }

    "/api/v1/showcase/$action" {
      controller = 'apiShowcase'
    }

    "/api/v1/tempUser/$action" {
      controller = 'apiTemporalUser'
    }

    "/api/v1/trackingEvaluation/$action" {
      controller = 'apiTrackingEvaluation'
    }

    "/api/v1/crezcamosJuntos/$action" {
      controller = 'apiCrezcamosJuntos'
    }

    "/api/v1/batchProcess/$action" {
      controller = 'apiBatchProcess'
    }

    "/api/v1/restFulService/vitrina/login" {
      controller = 'vitrinaInfotec'
      action = 'validateLogin'
    }

    "/api/v1/restFulService/vitrina/getUsersByRfc" {
      controller = 'vitrinaInfotec'
      action = 'getUsersByRfc'
    }

    "/api/v1/restFulService/vitrina/providerConfirms" {
      controller = 'vitrinaInfotec'
      action = 'providerConfirms'
    }

    "/api/v1/restFulService/vitrina/startAccreditation" {
      controller = 'vitrinaInfotec'
      action = 'startAccreditation'
    }

    "/api/v1/restFulService/vitrina/testStartAccreditationINFOTEC" {
      controller = 'vitrinaInfotec'
      action = 'testStartAccreditationINFOTEC'
    }

    "/api/v1/restFulService/vitrina/getDocument" {
      controller = 'vitrinaInfotec'
      action = 'getDocument'
    }

    "/api/v1/restFulService/$action" {
      controller = 'vitrinaInfotec'
    }

    "/api/v1/feedback/$action" {
      controller = 'apiFeedback'
    }

    "/api/v1/logRequest/$action" {
      controller = 'apiLogRequest'
    }

    "/app/$controller/$action?/$id?"{
      constraints {
      // apply constraints here
      }
    }
  
	"/api/v1/impacts/$action"{
      controller = 'apiImpacts'
  }

    "/api/v1/normativeRequirement/$action"{
      controller = 'normativeRequirement'
    }

    "/api/v1/extraPoints/$action"{
      controller = 'apiExtraPoints'
    }

		"500"(view:'/error')
	}
}
