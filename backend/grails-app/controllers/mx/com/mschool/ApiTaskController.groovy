package mx.com.mschool

import grails.converters.JSON

class ApiTaskController {

    def userService
    def profileService

    def shouldUploadLegalDocs() {

        def data = [upload: false]
        def user = userService.loggedUser
        def applicantProfile = profileService.getCurrentProfile(user)

        if(applicantProfile.uploadLegalDocs) {
          data = [
            upload: true
          ]
        } else {
          def applications = Application.findAllByApplicantProfile(applicantProfile)

          applications = applications.grep {
            def normativeEvaluation = NormativeEvaluationEvent.findByApplication(it)
            normativeEvaluation != null && normativeEvaluation.signEvent != null && normativeEvaluation.passedEvaluation
          }

          data = [
            upload: applications.size() > 0
          ]

          applicantProfile.uploadLegalDocs = true
          applicantProfile.save()

        }

        render data as JSON
    }
}
