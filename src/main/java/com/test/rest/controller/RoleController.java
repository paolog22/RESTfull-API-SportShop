package com.test.rest.controller;

import com.test.model.dto.RoleDto;
import com.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Павел on 08.11.2016.
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "admin/role/update", method = RequestMethod.PUT)
    public ResponseEntity<?> editRole(@RequestBody RoleDto roleDto,
                                      @RequestHeader(name = "Authorization") String token) throws Exception {
        RoleDto existingRoleDto;
        try {
            existingRoleDto = roleService.editRole(roleDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(existingRoleDto, HttpStatus.OK);
    }

    @RequestMapping(value = "admin/role/add", method = RequestMethod.POST)
    public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto,
                                     @RequestHeader(name = "Authorization") String token) throws Exception {
        RoleDto existingRoleDto;
        try {
            existingRoleDto = roleService.addRole(roleDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(existingRoleDto, HttpStatus.OK);
    }

    @RequestMapping(value = "admin/role/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> addRole(@PathVariable Long id,
                                     @RequestHeader(name = "Authorization") String token) throws Exception {
        try {
            roleService.deleteRole(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok().build();
    }
}
