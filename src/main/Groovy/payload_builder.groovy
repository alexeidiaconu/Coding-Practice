import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

int nrbuylines = Integer.parseInt(vars.get('numberOfBuylines'))

def payload = [
        buylines: []
]

def buyline_json = '''
		{
			"id": null,
			"buyline_status": "DRAFT",
			"estimate_id": 1593,
			"creation_source": "MANUAL",
			"hierarchy_level": "NONE",
			"approved_for_ordering": false,
			"selected": false,
			"attributes": {
				"lineType": "MEDIA",
				"supplierId": 10000000,
				"supplierCode": "MD_Supplier",
				"subMediaTypeId": 1001,
				"mdmMediaTypeId": 1003,
				"vendorId": 1010,
				"tx_formula": "",
				"startDate": "2026-03-01",
				"endDate": "2026-04-30",
				"packageType": "Parent",
				"budgetPercent": 1,
				"totalPeriodBudget": 0,
				"sumVendorNet": 20,
				"sumVendorGross": 20,
				"totalClientNet": 0,
				"totalClientGross": 0,
				"allocatedBudget": 20,
				"currencyId": 1,
				"pricingType": "UNITS",
				"allocationType": "VENDOR_NET",
				"rate": 10,
				"units": 2,
				"vendorNet": 20,
				"vendorGross": 20,
				"netPercentage": "1.0000",
				"unitType": "Actions",
				"clientFactor": 1,
				"orderable": true,
				"excludeFromMaf": false,
				"commissionable": true,
				"billable": true,
				"isReconcilable": true,
				"payable": true,
				"taxable": true,
				"mediaInvestment": false,
				"primaryContactInfo": "",
				"lineName": [
					"Line 1"
				],
				"flighting": [
					{
						"period": "2026-03-01",
						"plannedBudget": 10,
						"units": 1,
						"vendorNet": 10,
						"vendorGross": 10,
						"clientNet": 10,
						"payableAmount": 10,
						"taxableAmount": 10,
						"periodEnd": "2026-03-31",
						"startDate": "2026-03-01",
						"endDate": "2026-03-31"
					},
					{
						"period": "2026-04-01",
						"plannedBudget": 10,
						"units": 1,
						"vendorNet": 10,
						"vendorGross": 10,
						"clientNet": 10,
						"payableAmount": 10,
						"taxableAmount": 10,
						"periodEnd": "2026-04-30",
						"startDate": "2026-04-01",
						"endDate": "2026-04-30"
					}
				],
				"platformSubaccount": "N/A",
				"platformSubaccountName": "N/A",
				"spendingCap": 0,
				"platformClientCurrency": "USD",
				"estimate": 1593,
				"insertionDate": "2026-03-01",
				"product": "MD_ALX_1_P1 - ALXP1"
			}
		}
'''

def buyline = new JsonBuilder()
def buylineMap = new JsonSlurper().parseText(buyline_json);

for (int i in 1..nrbuylines) {
    def cbuyline = buylineMap

    // Modify whatever you need
    cbuyline.attributes.lineName = ["Line ${i}"]

    payload.buylines.add(cbuyline)
}

println payload
