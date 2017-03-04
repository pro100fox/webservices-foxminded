# one Ruby package for SOAP-based services
require 'soap/wsdlDriver'

wsdl_url = 'http://localhost:9999/ws/hello?wsdl'

service = SOAP::WSDLDriverFactory.new(wsdl_url).create_rpc_driver

# Invoke service operations.
data1 = service.getHelloWorldAsString('mkyong')

# Output results.
puts "getHelloWorldAsString : #{data1}"