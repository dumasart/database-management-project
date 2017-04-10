ALTER SYSTEM ENABLE RESTRICTED SESSION;

begin     
    for x in (  
	select Sid, Serial#, machine, program  
	from v$session  
	where  
	machine <> 'MyDatabaseServerName'  
    ) loop  
    execute immediate 'Alter System Kill Session '''|| x.Sid  
    || ',' || x.Serial# || ''' IMMEDIATE';  
    end loop;  
end;
