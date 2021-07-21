# SpringbootAppUsing-ELK
This is a demo application for springboot on how to use Elasticsearch Logstash and Kibana

+++++++++++++++++++++++++++++++++++++

	//================
		1. download Elasticsearch // or you can run with docker
		2.run elasticsearch.bat using the command prompt. Elasticsearch can then be accessed at localhost:9200  (IN CMD)
		3.Download Kibana
		4.Modify the kibana.yml(config folder) to point to the elasticsearch instance. In our case this will be 9200. So uncomment the following line in kibana.yml-
		  elasticsearch.url: "http://localhost:9200"
		5.Run the kibana.bat  (in bin folder) using the command prompt. kibana UI can then be accessed at localhost:5601
		6.Download Logstash
		7.Create a configuration file named logstash.conf.,, TO BE STORED ON THE SAME FOLDER WHERE Logstash ,,, 
            	input {
									  file {
										type => "java"
										path => "C:/elk/spring-boot-elk.log"   # the file where the logs are being written for your application
										codec => multiline {
										  pattern => "^%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME}.*"
										  negate => "true"
										  what => "previous"
										}
									  }
									}
									 
									filter {
									  #If log line contains tab character followed by 'at' then we will tag that entry as stacktrace
									  if [message] =~ "\tat" {
										grok {
										  match => ["message", "^(\tat)"]
										  add_tag => ["stacktrace"]
										}
									  }
									 
									}
									 
									output {
									   
									  stdout {
										codec => rubydebug
									  }
									 
									  # Sending properly parsed log events to elasticsearch
									  elasticsearch {
										hosts => ["localhost:9200"]
									  }
									}
