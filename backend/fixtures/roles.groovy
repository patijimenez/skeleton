import mx.gob.inadem.*
1
fixture {
	RolFisica(Role) {
		name = "Física"
		permissions = ["fiel:uploadTmp", "apiFiel:useUploadedRfc", "apiFiel:saveUploaded", "apiProfile:getApplicantData", "apiProfile:saveAddress", "apiProfile:updateIndividual", "apiProfile:getUserData"]
	}
	RolEstudiante(Role) {
		name = "Estudiante"
		permissions = ["apiProfile:getApplicantData", "apiProfile:saveAddress", "apiProfile:updateStudent", "apiProfile:getUserData"]
	}
	RolGobierno(Role) {
		name = "Gobierno"
		permissions = ["fiel:uploadTmp", "apiFiel:useUploadedRfc", "apiFiel:saveUploaded", "apiProfile:getApplicantData", "apiProfile:saveAddress", "apiProfile:updateGovernment", "apiProfile:getUserData"]
	}
	RolMoral(Role) {
		name = "Moral"
		permissions = ["fiel:uploadTmp", "apiFiel:useCompanyUploadedRfc", "apiFiel:saveCompanyUploaded", "apiProfile:getApplicantData", "apiProfile:saveAddress", "apiProfile:updateCompany", "apiProfile:updateCompanyIndividual", "apiProfile:getUserData"]
	}
	RolOtros(Role) {
		name = "Otro"
		permissions = ["fiel:uploadTmp", "apiFiel:useUploadedRfc", "apiFiel:saveUploaded", "apiProfile:getApplicantData", "apiProfile:saveAddress", "apiProfile:updateOther", "apiProfile:getUserData"]
	}
  RolDirectorArea(Role) {
    name = "Director de Área"
    permissions = ["apiProfile:getUserData","fiel:uploadTmp", "apiFiel:useGeneralUploadedRfc","apiFiel:saveGeneralUploaded", "apiProfile:updateGeneral", "apiProfile:changePassword", "apiFiel:loadUserCert"]
  }
  RolDirectorGeneralAdjunto(Role) {
    name = "Director General Adjunto"
    permissions = ["apiProfile:getUserData","fiel:uploadTmp", "apiFiel:useGeneralUploadedRfc","apiFiel:saveGeneralUploaded", "apiProfile:updateGeneral", "apiProfile:changePassword", "apiFiel:loadUserCert"]
  }
  RolJefeDepartamento(Role) {
    name = "Jefe de Departamento"
    permissions = ["apiProfile:getUserData","fiel:uploadTmp", "apiFiel:useGeneralUploadedRfc","apiFiel:saveGeneralUploaded", "apiProfile:updateGeneral", "apiProfile:changePassword", "apiFiel:loadUserCert"]
  }
  RolUsuarioINADEM(Role) {
    name = "Funcionario INADEM"
    permissions = ["apiProfile:getUserData","fiel:uploadTmp", "apiFiel:useGeneralUploadedRfc","apiFiel:saveGeneralUploaded", "apiProfile:updateGeneral", "apiProfile:changePassword", "apiFiel:loadUserCert"]
  }
  RolUsuarioExterno(Role) {
    name = "Funcionario Externo"
    permissions = ["apiProfile:getUserData","fiel:uploadTmp", "apiFiel:useGeneralUploadedRfc","apiFiel:saveGeneralUploaded", "apiProfile:updateGeneral", "apiProfile:changePassword", "apiFiel:loadUserCert"]
  }
  RolUsuarioEvaluador(Role) {
    name = "Evaluador"
    permissions = ["apiProfile:getUserData","fiel:uploadTmp", "apiFiel:useGeneralUploadedRfc","apiFiel:saveGeneralUploaded", "apiProfile:updateGeneral", "apiProfile:changePassword", "apiFiel:loadUserCert"]
  }
  RolConsejeroEstatal(Role) {
	  name = "Consejero Estatal"
	  permissions = ["apiProfile:getUserData","fiel:uploadTmp", "apiFiel:useGeneralUploadedRfc","apiFiel:saveGeneralUploaded", "apiProfile:updateGeneral", "apiProfile:changePassword", "apiFiel:loadUserCert"]
	}
}

